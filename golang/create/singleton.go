package main
import (
    "sync"
    "testing"
)
type singleton struct {
    resource int
}
var instance *singleton
var once sync.Once
func (s *singleton) getInstance() *singleton {
    once.Do(func() {
        instance = &singleton{0}
    })
    return instance
}

func TestSingle(t *testing.T) {
    if instance.getInstance().resource == 1 {
        t.Errorf("err %d", 1)
    }
}
