def find_inputs(filename):
    ops = reset_ops(filename)

    for noun in range(0, 100):
        for verb in range(0, 100):
            ops[1] = noun
            ops[2] = verb
            if parse_op_codes(ops) == 19690720:
                return 100 * noun + verb
            else:
                ops = reset_ops(filename)
        ops = reset_ops(filename)

    print("No noun and verb found to return value 19690720.")
    exit(1)


def parse_op_codes(ops):
    for position in range(0, len(ops), 4):
        if ops[position] == 99:
            return ops[0]
        elif ops[position] != 1 and ops[position] != 2:
            print(
                f"Parsing ops ({ops[position]}, {ops[position+1]}, {ops[position+2]}, {ops[position+3]})")
            print(f"Unknown opcode {ops[position]} found.")
            exit(1)
        input_1 = ops[position+1]
        input_2 = ops[position+2]
        output = ops[position+3]
        if ops[position] == 1:
            ops[output] = ops[input_1] + ops[input_2]
        elif ops[position] == 2:
            ops[output] = ops[input_1] * ops[input_2]
    return ops[0]


def reset_ops(filename):
    with open(filename, 'r') as f:
        ops = f.readline().split(',')
        ops = [int(op) for op in ops]
    return ops


if __name__ == "__main__":
    print(find_inputs('puzzle_input.txt'))
