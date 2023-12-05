use std::cmp::min;

pub fn main() {
    let mut line = String::new();
    std::io::stdin().read_line(&mut line).unwrap();

    let numbers: Vec<i32> = line.split(' ')
        .map(|s| s.trim().parse().unwrap())
        .collect();

    let n = numbers[0];
    let x = numbers[1];
    let y = numbers[2];

    let output = steps(n, x, y);
    if output.0 >= 0 && output.1 >= 0 {
        println!("{} {}", output.0, output.1)
    } else {
        println!("{}", -1)
    }
}

fn steps(n: i32, x: i32, y: i32) -> (i32, i32) {
    return if n % x == 0 {
        (n / x, 0)
    } else if n % y == 0 {
        (0, n / y)
    } else {
        let min = min(x, y);
        if n - min > 0 {
            let r = steps(n - min, x, y);
            if r.0 < 0 || r.1 < 0 { (-1, -1) } else {
                if min == x {
                    (1 + r.0, r.1)
                } else {
                    (r.0, 1 + r.1)
                }
            }
        } else { (-1, -1) }
    };
}