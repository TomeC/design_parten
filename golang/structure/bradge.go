package main

import "container/list"

type Sender interface {
	Send(level, msg string)
}
type PhoneSender struct {
	phones *list.List
}
func NewPhoneSender(phs *list.List) *PhoneSender{
	return &PhoneSender{phs}
}
func (p *PhoneSender) Send(level, msg string) {
	for iter := p.phones.Front(); iter != nil; iter = iter.Next() {
		println(level, "call phone:", iter.Value.(string), "msg:", msg)
	}
}

type EmailSender struct {
	mails *list.List
}
func NewEmailSender(mls *list.List) *EmailSender{
	return &EmailSender{mls}
}
func (e *EmailSender) Send(level, msg string) {
	for iter := e.mails.Front(); iter != nil; iter = iter.Next() {
		println(level, "send mail to:", iter.Value.(string), "msg:", msg)
	}
}

type Notify interface {
	notify(msg string)
}
type NormalNotify struct {
	sender Sender
}
func NewNormalNotify(s Sender) *NormalNotify {
	return &NormalNotify{s}
}
func (n *NormalNotify) Notify(msg string)  {
	n.sender.Send("normal", msg)
}

type UrgencyNotify struct {
	sender Sender
}
func NewUrgencyNotify(s Sender) *UrgencyNotify {
	return &UrgencyNotify{s}
}
func (n *UrgencyNotify) Notify(msg string)  {
	n.sender.Send("urgency", msg)
}

func main() {
	emails := list.New()
	emails.PushBack("tom@qq.com")
	emails.PushBack("jerry@qq.com")
	eSender := NewEmailSender(emails)
	normal := NewNormalNotify(eSender)
	normal.Notify("start success")

	phones := list.New()
	phones.PushBack("173")
	phones.PushBack("185")
	pSender := NewPhoneSender(phones)
	urgency := NewUrgencyNotify(pSender)
	urgency.Notify("server down")
}
