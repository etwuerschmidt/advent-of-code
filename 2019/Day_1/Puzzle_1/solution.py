import math
import pytest


def compute_fuel(filename):
    modules = []
    with open(filename, 'r') as f:
        modules = [int(line.strip()) for line in f]

    total = 0
    for module in modules:
        total += math.floor(module / 3) - 2
    return total


def test_compute_fuel():
    assert compute_fuel('test_input.txt') == 2 + 2 + 654 + 33583


if __name__ == "__main__":
    print(compute_fuel('puzzle_input.txt'))
