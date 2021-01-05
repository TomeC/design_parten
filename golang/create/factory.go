package main

// 简单工厂
type Rule interface {
    getName() string
}
type RuleA struct {
}
func (r *RuleA) getName() string {
    return "RuleA"
}
type RuleB struct {
}
func (r *RuleB) getName() string {
    return "RuleB"
}

type SimpleFactory struct {
}
func (f *SimpleFactory) getRule(name string) Rule {
    if name == "RuleA" {
        return &RuleA{}
    } else if name == "RuleB" {
        return &RuleB{}
    }
    return nil
}
// 抽象工厂
type IFactory interface {
    getRule(string) Rule
}
type FactoryA struct {
}
func (fa *FactoryA) getRule(name string) Rule {
    if name == "RuleA" {
        return &RuleA{}
    } else if name == "RuleB" {
        return &RuleB{}
    }
    return nil
}

type FactoryB struct {
}
func (fa *FactoryB) getRule(name string) Rule {
    if name == "RuleA" {
        return &RuleA{}
    } else if name == "RuleB" {
        return &RuleB{}
    }
    return nil
}
type FactoryProducer struct {
}
func (fp *FactoryProducer) getFactory(t string) IFactory {
    if t == "A" {
        return &FactoryA{}
    } else if t == "B" {
       return &FactoryB{}
   }
   return nil
}
func main() {
    println("simple factory")
    sf := SimpleFactory{}
    r := sf.getRule("RuleA")
    if r != nil {
        println(r.getName())
    }

    println("abstract factory")
    fp := FactoryProducer{}
    fa := fp.getFactory("A")
    println(fa.getRule("RuleB").getName())
}

