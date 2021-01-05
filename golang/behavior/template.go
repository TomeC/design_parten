package main

import "fmt"

type TaskTemplate struct {
	beforeTask func()
	afterTask func()
}
func (task *TaskTemplate) inTask() {
	fmt.Println("in task")
}
func (task *TaskTemplate) runTask() {
	task.beforeTask()
	task.inTask()
	task.afterTask()
}
// 具体执行任务的构造体
type MyTaskTemplate struct {
	// "继承"模板类
	TaskTemplate
}

// 实现模板中的beforeTask方法
func (my *MyTaskTemplate) beforeTask() {
	fmt.Println("my before task")
}
// 实现模板中的afterTask方法
func (my *MyTaskTemplate) afterTask() {
	fmt.Println("my after task")
}
// 构造一个MyTaskTemplate结构体
func NewMyTaskTemplate() *MyTaskTemplate {
	myTask := new(MyTaskTemplate)

	// 将"父类"中的函数字段设为自己的实现
	myTask.TaskTemplate.beforeTask = myTask.beforeTask
	myTask.TaskTemplate.afterTask = myTask.afterTask

	return myTask
}

func main() {
	m := NewMyTaskTemplate()
	m.runTask()

}
