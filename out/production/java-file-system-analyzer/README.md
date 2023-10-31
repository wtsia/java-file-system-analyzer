# FileSystemAnalyzer

FileSystemAnalyzer is a Java application designed to perform analysis on a specified directory, offering insights into file types, sizes, and top N counts present in the directory. It utilizes various algorithms and data structures to achieve this analysis, such as recursion, binary search tree, linked lists, and heaps.

## Overview

The `FileSystemAnalyzer` class serves as the main entry point for conducting directory analysis. Upon execution, it performs a detailed analysis of the specified directory, displaying information on various file attributes, collecting data into a linked list, and subsequently transferring it to a max heap for further processing.

## Features

- **Directory Analysis**: Analyzes files and subdirectories within the specified directory, collecting information about file types, sizes, etc.
- **Data Collection**: Utilizes a linked list to gather file names and types for subsequent data processing.
- **Max Heap Integration**: Transfers data from the linked list to a max heap to identify the top N counts of file types in the directory.

## Algorithms and Data Structures

- **Recursion**: Recursively traverses the directory to perform analysis.
- **Binary Search Tree**: Organizes and manages the file data for efficient retrieval.
- **Linked List**: Collects and organizes file names and types during analysis.
- **Max Heap**: Identifies top N counts of file types present in the directory.

## Usage

To run the `FileSystemAnalyzer`:

1. Specify the root directory you want to analyze within the `main` method.
2. Compile and execute the program.
3. View the analyzed data, including directory trees and top N file type counts in the console output.

## Requirements

- Java (JDK 8 or later)

## Execution

To execute the project:

```bash
javac FileSystemAnalyzer.java
java FileSystemAnalyzer
