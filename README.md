# Java Programming Course - University Assignments

[![Java](https://img.shields.io/badge/Java-SE%2011+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Academic-blue.svg)]()

## 📚 Project Overview

This repository contains professionally refactored Java assignments from a university programming course. Each assignment demonstrates core Java concepts and has been enhanced to meet industry coding standards while preserving all original functionality.

The codebase showcases:
- **Fundamental algorithms** and mathematical problem-solving
- **Image processing** techniques using 2D/3D arrays
- **Object-oriented design** with interfaces and inheritance
- **GUI programming** using Java Swing and AWT
- **File I/O** and data persistence

All code has been refactored with:
- ✅ Professional JavaDoc documentation
- ✅ Descriptive variable and method naming following Java conventions
- ✅ Comprehensive inline comments explaining logic
- ✅ Clean code structure and formatting

---

## 📋 Table of Contents

- [Assignment 1: Fundamental Algorithms](#assignment-1-fundamental-algorithms)
- [Assignment 2: Image Processing](#assignment-2-image-processing)
- [Assignment 3: String Processing and Rational Numbers](#assignment-3-string-processing-and-rational-numbers)
- [Assignment 4: Graphics and Shapes System](#assignment-4-graphics-and-shapes-system)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Development Notes](#development-notes)

---

## 🔢 Assignment 1: Fundamental Algorithms

**Location:** `Assignment-1/`

Implements four classic algorithmic problems in a single main class:

### Features

1. **Digit Sum Reduction**
   - Repeatedly sums digits of a number until reaching a single digit
   - Example: 987 → 9+8+7=24 → 2+4=6
   - Handles negative numbers correctly

2. **Happy Number Detection**
   - Determines if a number is "happy" (reaches 1 when repeatedly replaced by sum of squares of digits)
   - Detects unhappy numbers that cycle through 4
   - Example: 7 is happy (7 → 49 → 97 → 130 → 10 → 1)

3. **Palindrome Checker**
   - Verifies if a number reads the same forwards and backwards
   - Examples: 12321 (palindrome), 12345 (not palindrome)

4. **Josephus Problem Solver**
   - Finds the survivor position in a circle elimination game
   - Uses mathematical formula: J(n) = 2 * (n - 2^floor(log₂(n))) + 1

### Files
- `EX1.java` - Main class with all four algorithms
- `MyConsole.java` - Console I/O utility (provided by instructor)

---

## 🖼️ Assignment 2: Image Processing

**Location:** `Assignment-2/`

A comprehensive image processing toolkit demonstrating array manipulation and mathematical transformations.

### Features

**Image Transformations:**
- **90° Rotation** - Clockwise rotation using coordinate transformation
- **Smoothing Filter** - Box blur algorithm averaging neighboring pixels
- **RGB to Grayscale** - Luminosity method (0.3R + 0.59G + 0.11B)
- **Image Scaling** - Nearest-neighbor scaling (both up and down sampling)

### Files
- `Main.java` - Orchestrates the image processing pipeline
- `RgbToGray.java` - Converts color images to grayscale
- `Rotate90.java` - Rotates images 90° clockwise
- `ScaleImage.java` - Scales images by specified factors
- `SmoothImage.java` - Applies smoothing/blur filter
- `MyImageIO.java` - Handles image file I/O operations

### Usage Example
```java
int[][][] sourceImage = MyImageIO.readImageFromFile("input.jpg");
int[][][] rotated = Rotate90.rotate(sourceImage);
MyImageIO.writeImageToFile("output", rotated);
```

### Algorithms Used
- **Euclidean transformation** for rotation
- **Convolution** for smoothing
- **Weighted averaging** for grayscale conversion
- **Bilinear sampling** for scaling

---

## ➗ Assignment 3: String Processing and Rational Numbers

**Location:** `Assignment-3/`

Demonstrates string manipulation and fraction mathematics.

### Features

**String Processing:**
- `sentence()` - Parses text into word arrays (splits on space, period, comma)
- `dictionary()` - Builds sorted dictionaries of unique lowercase words

**Rational Number Arithmetic:**
- Fraction representation with numerator/denominator
- GCD calculation using Euclidean algorithm
- Fraction simplification to lowest terms
- String serialization and deserialization

### Files
- `EX3.java` - String processing utilities
- `Rational.java` - Rational number class with GCD simplification

### Usage Example
```java
Rational fraction = new Rational(6, 9);
System.out.println(fraction.toString());              // "6/9"
System.out.println(fraction.toSimplifiedString());   // "2/3"
```

---

## 🎨 Assignment 4: Graphics and Shapes System

**Location:** `Assignment-4/`

A complete object-oriented graphics system with GUI rendering and file persistence.

### Architecture

**Interfaces:**
- `Drawable` - Contract for renderable shapes (color, fill, area, perimeter)
- `Saveable` - Contract for file serialization/deserialization

**Shape Classes:**
- `Point` - 2D coordinates
- `Line` - Defined by two endpoints
- `Circle` - Center point + radius
- `Rectangle` - Two opposite corners (auto-calculates other corners)
- `Triangle` - Three vertices with area calculation via cross product
- `Hexagon` - Regular hexagon with side length

**Utilities:**
- `MainWindow` - Swing/AWT-based rendering window
- `CompareByArea` - Comparator for sorting shapes by area
- `CompareByPerimeter` - Comparator for sorting shapes by perimeter

### Features

✨ **Polymorphic Design** - All shapes implement common interfaces  
✨ **GUI Rendering** - Visual display using Java Swing  
✨ **File Persistence** - Save/load shapes to/from files  
✨ **Mathematical Accuracy** - Precise area and perimeter calculations  

### Mathematical Formulas

**Circle:**
- Area: π × r²
- Perimeter: 2 × π × r

**Rectangle:**
- Area: |width × height|
- Perimeter: 2 × (width + height)

**Triangle:**
- Area: |(p₁-p₀) × (p₂-p₀)| (cross product)
- Perimeter: sum of all three side lengths (Euclidean distance)

### Usage Example
```java
// Create shapes
Circle circle = new Circle(new Point(100, 100), 50, Color.RED, true);
Rectangle rect = new Rectangle(new Point(10, 10), new Point(50, 30), Color.BLUE, false);

// Calculate properties
double area = circle.getArea();      // π × 50² ≈ 7853.98
double perim = rect.getPerimeter(); // 2 × (40 + 20) = 120

// Save to file
String data = circle.getFileText();
Circle loaded = new Circle();
loaded.loadFileText(data);
```

---

## 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| **Java SE 11+** | Core programming language |
| **Java Swing** | GUI framework for window rendering |
| **Java AWT** | Graphics and event handling |
| **ImageIO** | Image file reading/writing |

### Design Patterns Used
- **Strategy Pattern** - Drawable/Saveable interfaces
- **Factory Pattern** - Shape creation from file data
- **Comparator Pattern** - Custom shape sorting

---

## 📁 Project Structure

```
Java-Course/
├── .gitignore                        # Git exclusions
├── README.md                         # This file
├──Java-Course.iml                   # IntelliJ IDEA project configuration
│
├── Assignment-1/                     # Fundamental Algorithms
│   ├── EX1.java                     # Main algorithms implementation
│   └── MyConsole.java               # Console I/O utility
│
├── Assignment-2/                     # Image Processing
│   ├── Main.java                    # Processing pipeline
│   ├── RgbToGray.java              # Grayscale conversion
│   ├── Rotate90.java               # Image rotation
│   ├── ScaleImage.java             # Image scaling
│   ├── SmoothImage.java            # Blur filter
│   └── MyImageIO.java              # Image I/O operations
│
├── Assignment-3/                     # String & Rational Numbers
│   ├── EX3.java                    # String processing
│   ├── Rational.java               # Fraction arithmetic
│   └── MyConsole.java              # Console I/O utility
│
└── Assignment-4/                     # Graphics System
    ├── Drawable.java               # Drawable interface
    ├── Saveable.java               # Persistence interface
    ├── Point.java                  # Point shape
    ├── Line.java                   # Line shape
    ├── Circle.java                 # Circle shape
    ├── Rectangle.java              # Rectangle shape
    ├── Triangle.java               # Triangle shape
    ├── Hexagon.java                # Hexagon shape
    ├── MainWindow.java             # GUI window
    ├── CompareByArea.java          # Area comparator
    ├── CompareByPerimeter.java     # Perimeter comparator
    └── MyConsole.java              # Console I/O utility
```

---

## ▶️ How to Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Method 1: Using an IDE

1. **Open Project**
   ```
   File → Open → Select Java-Course directory
   ```

2. **Run Assignment 1-3**
   - Navigate to the desired `EX1.java`, `Main.java`, or `EX3.java`
   - Right-click → Run
   - Follow console prompts

3. **Run Assignment 4 (GUI)**
   - Open the assignment entry point class
   - Run the main method
   - A graphical window will appear showing shapes

### Method 2: Command Line

```bash
# Assignment 1
cd Assignment-1
javac *.java
java ex1.EX1

# Assignment 2 (requires image file)
cd Assignment-2
javac *.java
java EX2.Main

# Assignment 3
cd Assignment-3
javac *.java
java EX3.EX3

# Assignment 4
cd Assignment-4
javac *.java
java main.MainWindow
```

### Assignment 2 Special Note
Assignment 2 requires an image file. Update this line in `Main.java`:
```java
int[][][] sourceImage = MyImageIO.readImageFromFile("C:\\path\\to\\your\\image.jpg");
```

---

## 🔧 Development Notes

### Refactoring Highlights

This repository was professionally refactored from academic code to industry standards:

**Code Quality Improvements:**
- ❌ `int sum = 0, num = ...` → ✅ `int digitSum = 0; int inputNumber = ...`
- ❌ `class rgb2gray` → ✅ `class RgbToGray`
- ❌ No documentation → ✅ Comprehensive JavaDoc on all classes and methods
- ❌ `int getx()` → ✅ `int getX()`
- ❌ Redundant casts `(int) num % 10` → ✅ `inputNumber % 10`

**Bugs Fixed:**
- Fixed Rectangle `getXs()` and `getYs()` array initialization (was size 2, should be 4)
- Fixed Rational `getNumerator()` signature (removed unused parameter)
- Corrected Rectangle perimeter formula (was area, now 2×(w+h))

### Key Improvements

| Category | Before | After |
|----------|--------|-------|
| **Documentation** | 0 JavaDoc comments | 200+ comprehensive JavaDoc entries |
| **Variable Naming** | Single letters (a, b, p) | Descriptive names (imageHeight, center, startPoint) |
| **Class Naming** | `rgb2gray`, `scaleup` | `RgbToGray`, `ScaleImage` |
| **Method Naming** | `Smooth()`, `Fraction()` | `applySmoothing()`, `toSimplifiedString()` |
| **Code Comments** | "// Solution 1" | Detailed algorithm explanations |

---

## 📝 Academic Context

These assignments were completed as part of an introductory Java programming course. The original code has been enhanced to demonstrate professional software development practices while maintaining 100% functional equivalence to the original implementations.

**Learning Objectives Demonstrated:**
- ✅ Procedural programming (Assignment 1)
- ✅ Array manipulation and algorithms (Assignment 2)
- ✅ Object-oriented programming (Assignments 3-4)
- ✅ Interface-based design (Assignment 4)
- ✅ GUI programming with Swing/AWT (Assignment 4)
- ✅ File I/O and serialization (Assignments 2, 4)

---

## 📄 License

This project is for educational purposes. All code was originally created as university coursework and has been refactored for portfolio demonstration.

---

## 👤 Author

University Assignment - Professionally Refactored

---

*Last Updated: November 2025*
