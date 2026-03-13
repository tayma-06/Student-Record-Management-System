# Student Record Management System

**Author:** Khadiza Sultana  
**Language:** Java  
**Topics:** Generics, Collections Framework

---

## What This Project Does

A simple university student record system built in Java. It stores student details and lets you sort, search, and group them — all using Generics and the Collections Framework so the code stays clean and reusable.

---

## Files at a Glance

```
src
├── Student.java          # The student model (ID, name, GPA, gender)
├── DataStore.java        # Generic container — works with any object type
├── StudentService.java   # All logic: sort, search, group
└── Main.java             # Entry point — runs everything
```

---

## How to Run

**1. Compile all files**
```bash
javac Student.java DataStore.java StudentService.java Main.java
```

**2. Run the program**
```bash
java Main
```

---

## Navigating the Code

1.  `Main.java`  
This creates the DataStore, adds students, and calls each feature. Read this first to get the big picture.

2.  `Student.java`  
A data class containing all the fields and getters. Every other class depends on this one.

3.  `DataStore.java`  
The `DataStore<T>` class can hold any type, not just students. It wraps an ArrayList and keeps the rest of the code from depending on it directly.

4.  `StudentService.java`  
All four tasks are here:
- `sortByGpa(boolean ascending)` — sort records low-to-high or high-to-low
- `searchById(int id)` — find one student by ID
- `searchByName(String query)` — partial name search, case-insensitive
- `searchByMinGpa(double min)` — everyone above a GPA threshold
- `groupByGender()` — splits students into a `Map<String, List<Student>>`

---

## The Four Tasks (Quick Reference)

| Task | Method | Location |
|------|--------|----------|
| Generic storage | `DataStore<T>` | `DataStore.java` |
| Sort by GPA | `sortByGpa()` | `StudentService.java` |
| Search records | `searchById()`, `searchByName()`, `searchByMinGpa()` | `StudentService.java` |
| Group by gender | `groupByGender()` | `StudentService.java` |

---
