import math
import pytest


def compute_fuel(filename):
    modules = []
    with open(filename, 'r') as f:
        modules = [int(line.strip()) for line in f]

    total = 0
    for module in modules:
        module_total = 0
        while module > 0:
            module = math.floor(module / 3) - 2
            if module > 0:
                module_total += module
        total += module_total
    return total


def test_compute_fuel():
    assert compute_fuel('test_input.txt') == 2 + 2 + 966 + 50346


if __name__ == "__main__":
    print(compute_fuel('puzzle_input.txt'))
