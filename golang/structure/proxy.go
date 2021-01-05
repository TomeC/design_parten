package main
type IUser interface {
    login(string) bool
}
type User struct {
}
func (u *User) login(name string) bool {
    println(name, "login process")
    return true
}
type UserProxy struct {
    user User
}
func (p *UserProxy) login(name string) bool {
    println(name, "login begin ...")
    res := p.user.login(name)
    println(name, "login end ...")
    return res
}
func main() {
    proxy := UserProxy{User{}}
    proxy.login("tom")
}