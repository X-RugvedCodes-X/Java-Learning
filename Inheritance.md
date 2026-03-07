# Java Inheritance – Important Points & Nuances

## 1) Basics

* Inheritance is implemented using `extends` (classes) and `implements` (interfaces).
* Java supports **single inheritance** for classes, **multiple inheritance** for interfaces.
* Creates an **IS-A** relationship.

  ```java
  class Dog extends Animal {}
  ```

---

## 2) What gets inherited?

### ✔ Inherited

* **Public** and **protected** members.
* **Default (package-private)** members → only if subclass is in the **same package**.

### Not inherited

* **Constructors**
* **Private members** (they exist, but are not accessible directly in subclass)
* Static members are inherited but **not polymorphic** (more later).

---

## 3) Private ≠ Inherited (tricky favorite)

You **cannot access** them directly.

```java
class A {
    private int x = 10;
}
class B extends A {
    void print() {
        // System.out.println(x); compile error
    }
}
```

But they are still **present in memory** and can be accessed via **public/protected getters**.

---

## 4) Constructors & Inheritance

* Constructors are **not inherited**.
* Parent constructor is called **first**.
* If you don’t write `super()`, compiler inserts it.

```java
class A { A() {} }
class B extends A { B() { super(); } }
```

If parent has **no no-arg constructor**, child **must explicitly call** one.

---

## 5) Method Overriding Rules (VERY IMPORTANT)

### Conditions

* Same method signature (name + params).
* Return type → same or **covariant** (subtype allowed).
* Access level **cannot be reduced**.
* Cannot throw **broader checked exceptions**.

---

### Access rule example

```java
class A { protected void show() {} }
class B extends A {
    public void show() {}   // ✔ increase allowed
    // private/protected(default narrower) not allowed
}
```

---

### Exception rule example

If parent throws:

```java
void read() throws IOException
```

Child can:

* throw same
* throw subclass
* or throw nothing
  But **not** `Exception` or `Throwable`.

---

## 6) Final Methods

`final` method → **cannot override**.

```java
final void run() {}
```

But it **can still be inherited**.

---

## 7) Final Class

Cannot be extended.

```java
final class A {}
class B extends A {}
```

Example: `String`.

---

## 8) Static Methods – BIG INTERVIEW TRAP

Static methods are **hidden**, not overridden.

Which method runs depends on **reference type**, not object.

```java
class A { static void show() {} }
class B extends A { static void show() {} }

A obj = new B();
obj.show();   // A.show(), not B
```

No runtime polymorphism here.

---

## 9) Variables / Fields

Fields are also **hidden**, not overridden.

```java
class A { int x = 10; }
class B extends A { int x = 20; }

A obj = new B();
System.out.println(obj.x);  // 10
```

Again → **reference type matters**.

---

## 10) Runtime Polymorphism

Only for **instance methods**, not static, not fields.

```java
A obj = new B();
obj.run();  // B's version (if overridden)
```

Uses **dynamic method dispatch**.

---

## 11) Use of `super`

Used to:

* Access parent method
* Access parent variable
* Call parent constructor

```java
super.show();
super.x;
super();
```

Must be first statement in constructor.

---

## 12) Overriding vs Overloading

Interviewers mix these deliberately.

| Feature            | Overriding | Overloading  |
| ------------------ | ---------- | ------------ |
| Parameters         | Same       | Different    |
| Inheritance needed | Yes        | No           |
| Polymorphism       | Runtime    | Compile time |

---

## 13) Abstract Methods

If parent has abstract method → child **must implement** or be abstract.

```java
abstract void run();
```

---

## 14) `instanceof` & Casting

Used when parent reference holds child object.

```java
if (obj instanceof B) {
    B b = (B) obj;
}
```

Wrong cast → `ClassCastException`.

---

## 15) Object Class

Every class in Java **implicitly extends `Object`**.

---

## 16) Initialization Order (super important in interviews)

When creating child object:

1. Static blocks (parent → child)
2. Instance blocks (parent → child)
3. Constructors (parent → child)

---

## 17) Can we override private method?

No.
Because it’s **not visible**, child actually defines a **new method**, not override.

---

## 18) Can we override static with non-static?
 No → compile error.

Both must be static if hiding.

---

## 19) Can we change return type?

Only if **covariant**.

```java
A get();
B get();  // where B extends A ✔
```

---

## 20) Multiple Inheritance Ambiguity (Diamond)

Not allowed with classes → prevents confusion.

But allowed via interfaces (Java resolves).

---

## 21) If child doesn’t override?

Parent version executes.

---

## 22) Private + Final + Static methods

They are **early bound (compile time)** → no polymorphism.

---

## 23) Why constructors can’t be overridden?

Because overriding requires inheritance + runtime dispatch.
Constructors are not inherited.

---

## 24) Superclass reference = subclass object

Allowed (upcasting) automatically.

```java
Animal a = new Dog();
```

Reverse → needs explicit cast.

---
