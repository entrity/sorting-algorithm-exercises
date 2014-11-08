## The files

Each file whose name begins with the name of a sorting algorithm holds an implementation of the eponymous sorting algorithm.

The file named `test.rb` is a single script which generates test data and then runs all the implemented sorting algorithms on it, then outputs the duration which each execution required.

## Running the demos

This project includes a distinct file for each sorting algorithm. They are meant to be run as a suite and their results compared, but they can also be run individually.

**Example - Running heap sort demo by itself:**

```bash
$ ruby -r ./heap_sort_demo.rb -e "simple_test"
[10, 23, 25, 30, 37]
```

**Example - Running heap sort demo on a random array of custom length:**

```bash
$ ruby -r ./heap_sort_demo.rb -e "puts heap_sort((0..50).map{ rand(1000) }).inspect"
[63, 77, 222, 233, 436, 356, 92, 73, 659, 376, 124, 236, 702, 323, 112, 421, 343, 727, 506, 521, 221, 467, 540, 565, 604, 391, 597, 698, 716, 222, 330, 533, 651, 366, 687, 843, 890, 366, 406, 297, 535, 161, 541, 775, 827, 185, 270, 764, 901, 896, 9547]
```


**Example - Running all demos as a suite:**

```bash
$ ruby test.rb
```

**Example - Running all demos as a suite, using a file containing a JSON array of numbers to sort:**

```bash
$ ruby test.rb example.json
```