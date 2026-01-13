## Time and Space Complexity of Map Operations

| Operation              | Average Case | Worst Case | Explanation                                      |
| ---------------------- | ------------ | ---------- | ------------------------------------------------ |
| **Insert (put)**       | **O(1)**     | **O(n)**   | O(1) with good hashing; O(n) if all keys collide |
| **Get (lookup)**       | **O(1)**     | **O(n)**   | Worst case when all keys land in one bucket      |
| **Remove**             | **O(1)**     | **O(n)**   | Same collision reasoning                         |
| **ContainsKey**        | **O(1)**     | **O(n)**   | Internally similar to `get()`                    |
| **ContainsValue**      | **O(n)**     | **O(n)**   | Must scan all entries                            |
| **Size**               | **O(1)**     | **O(1)**   | Stored as a variable                             |
| **IsEmpty**            | **O(1)**     | **O(1)**   | Simple check                                     |
| **Clear**              | **O(n)**     | **O(n)**   | Must remove all entries                          |
| **Iteration**          | **O(n)**     | **O(n)**   | Visits every entry                               |
| **Rehashing (resize)** | —            | **O(n)**   | Happens occasionally when load factor exceeded   |

### Why Average Case Is O(1)
HashMaps rely on:
- Good hash function
- Uniform key distribution
- Controlled load factor (default 0.75 in Java)

## Important Java HashMap Note (Java 8+)
In Java 8 and later, if many keys collide:
- Buckets switch from Linked List → Red-Black Tree
- Worst-case lookup improves to: **O(log n)**
- Requirements are:
  - Hash collisions
  - Bucket size ≥ 8
  - Table size ≥ 64

## Space Complexity
- Overall Space **O(n)**, Where: `n` = number of key–value pairs
- Details:
  - Array of buckets → O(capacity)
  - Each entry → key + value + metadata
  - Extra space during resizing → O(n)

### Final Summary:
HashMap operations like insert, get, and remove run in O(1) average time and O(n) worst case due to collisions; in Java 8+, worst case improves to O(log n) as bucket shifts from LinkedList to Red-Black Trees. Space complexity is O(n).