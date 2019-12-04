import pytest

def parse_op_codes(filename, test=True):
    with open(filename, 'r') as f:
        ops = f.readline().split(',')
        ops = [int(op) for op in ops]
    
    if not test:
        ops[1] = 12
        ops[2] = 2

    for position in range(0, len(ops), 4):
        if ops[position] == 99:
            return ops
        elif ops[position] != 1 and ops[position] != 2:
            print(f"Unknown opcode {ops[position]} found.")
            exit(1)
        input_1 = ops[position+1]
        input_2 = ops[position+2]
        output = ops[position+3]
        if ops[position] == 1:
            ops[output] = ops[input_1] + ops[input_2]
        elif ops[position] == 2:
            ops[output] = ops[input_1] * ops[input_2]

def test_parse_op_code():
    assert parse_op_codes('test_input_1.txt') == [3500,9,10,70,2,3,11,0,99,30,40,50]
    assert parse_op_codes('test_input_2.txt') == [2,0,0,0,99]
    assert parse_op_codes('test_input_3.txt') == [30,1,1,4,2,5,6,0,99]

if __name__ == "__main__":
    print(parse_op_codes('puzzle_input.txt', test=False)[0])