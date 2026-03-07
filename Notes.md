# JDBC Driver Types – Short Explanation with Advantages and Disadvantages

## Type 1: JDBC–ODBC Bridge Driver

**How it works:**
Java Application → JDBC → ODBC → Database

### Advantages

* Easy to learn and use
* Useful for understanding JDBC basics
* No database-specific driver required

### Disadvantages

* Very slow due to multiple layers
* Platform dependent
* Requires ODBC installation on client machine
* Deprecated and removed from modern Java versions

**Usage:** Not used in real-world applications

---

## Type 2: Native-API Partly Java Driver

**How it works:**
Java Application → JDBC → Native Database API → Database

### Advantages

* Better performance than Type 1
* Direct interaction with database native libraries

### Disadvantages

* Platform dependent
* Requires native database libraries on client machine
* Difficult to deploy and maintain

**Usage:** Rarely used

---

## Type 3: Network Protocol Pure Java Driver

**How it works:**
Java Application → JDBC → Middleware Server → Database

### Advantages

* Platform independent
* No native libraries required on client side
* Can connect to multiple databases using middleware

### Disadvantages

* Requires middleware server
* Slower than Type 4
* Additional network overhead

**Usage:** Used in some enterprise applications

---

## Type 4: Thin Driver (Pure Java Driver)

**How it works:**
Java Application → JDBC → Database (Direct connection)

### Advantages

* Best performance
* Platform independent
* No native libraries required
* Easy to deploy and maintain
* Most secure and scalable

### Disadvantages

* Database-specific driver required

**Usage:** Most widely used JDBC driver

**Examples:**

* MySQL: mysql-connector-j
* Oracle: ojdbc
* PostgreSQL: postgresql

---

## Quick Comparison

| Driver Type | Performance | Platform Independent | Current Usage |
| ----------- | ----------- | -------------------- | ------------- |
| Type 1      | Very Low    | No                   | Deprecated    |
| Type 2      | Medium      | No                   | Rare          |
| Type 3      | Medium      | Yes                  | Limited       |
| Type 4      | High        | Yes                  | Most Used     |

---

# JDBC Components

JDBC components are classes and interfaces provided by the `java.sql` package that help Java applications communicate with databases.

---

## 1. DriverManager Class

* It is a **JDBC class** used to manage database drivers.
* Responsible for **loading JDBC drivers** and **establishing connections** to databases.
* Uses the `getConnection()` method to create a connection.

**Common Method:**

```java
Connection con = DriverManager.getConnection(url, username, password);
```

**Role:**

* Selects the appropriate driver based on the database URL.
* Acts as a bridge between Java application and JDBC driver.

---

## 2. Connection Interface

* Represents a **connection session** between Java application and database.
* Used to create SQL statements.
* Maintains transaction control.

**Key Methods:**

* `createStatement()`
* `prepareStatement()`
* `commit()`
* `rollback()`
* `close()`

**Role:**

* Provides access to database operations.

---

## 3. Statement Interface

* Used to **execute static SQL queries**.
* SQL queries are written directly in the program.

**Example:**

```java
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM student");
```

**Limitations:**

* Prone to SQL injection.
* Not efficient for repeated queries.

---

## 4. PreparedStatement Interface

* Used to execute **parameterized (dynamic) SQL queries**.
* SQL query is compiled only once.

**Example:**

```java
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO student VALUES (?, ?)"
);
ps.setInt(1, 101);
ps.setString(2, "John");
ps.executeUpdate();
```

**Advantages:**

* Better performance.
* Prevents SQL injection.
* Easier to maintain.

---

## 5. ResultSet Interface

* Used to store and process data returned from a `SELECT` query.
* Works like a cursor pointing to rows in a table.

**Common Methods:**

* `next()`
* `getInt()`
* `getString()`

**Example:**

```java
while(rs.next()) {
    System.out.println(rs.getInt(1) + " " + rs.getString(2));
}
```

---

# JDBC Program Flow (Execution Steps)

This is the **standard sequence** followed while writing a JDBC program.

---

## Step 1: Connect IDE with Database

* Add the required **JDBC driver JAR** to the project.
* Example: MySQL Connector, Oracle JDBC, PostgreSQL JDBC.

**Purpose:**

* Enables Java application to communicate with the database.

---

## Step 2: Load Necessary Drivers

* Loads the JDBC driver into memory.
* Optional in modern JDBC (auto-loading supported).

**Example:**

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

---

## Step 3: Create Connection

* Establishes a connection between Java application and database.

**Example:**

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/dbname",
    "user",
    "password"
);
```

---

## Step 4: Create Statement

* Create either `Statement` or `PreparedStatement` object.

**Examples:**

```java
Statement stmt = con.createStatement();
```

or

```java
PreparedStatement ps = con.prepareStatement(sql);
```

---

## Step 5: Execute Query

* Execute SQL statements using:

  * `executeQuery()` → SELECT
  * `executeUpdate()` → INSERT, UPDATE, DELETE

**Example:**

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM student");
```

---

## Step 6: Process Result

* Retrieve data from `ResultSet` using getter methods.

---

## Step 7: Close Resources

* Close `ResultSet`, `Statement`, and `Connection` to free resources.

**Example:**

```java
rs.close();
stmt.close();
con.close();
```

---

# Short Interview Summary

* **DriverManager** → Manages drivers and connections
* **Connection** → Represents database connection
* **Statement / PreparedStatement** → Executes SQL queries
* **ResultSet** → Stores query result
* **Preferred Statement** → PreparedStatement

---

