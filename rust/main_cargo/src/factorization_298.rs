use std::collections::BTreeMap;

pub fn main() {
    let n = get_num();
    let factors = get_factors(n);

    let size = factors.len();
    for factor in factors.iter().enumerate() {
        if *factor.1.1 == 1 {
            print!("{}", factor.1.0);
        } else {
            print!("{}^{}", factor.1.0, factor.1.1);
        }
        if factor.0 != size - 1 {
            print!("*")
        }
    }
}

fn get_num() -> i32 {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap_or_default();
    return input.trim().parse().unwrap_or_default();
}

fn get_factors(mut n: i32) -> BTreeMap<i32, i32> {
    let mut factors = BTreeMap::new();

    if !is_prime(n) {
        let root = (n as f32).sqrt() as i32;
        while n > 1 {
            if is_prime(n) {
                match factors.get_mut(&n) {
                    None => {
                        factors.insert(n, 1);
                    }
                    Some(item) => {
                        *item = *item + 1;
                    }
                }
                break;
            }
            for i in 2..=root {
                if is_prime(i) && n % i == 0 {
                    n = n / i;
                    match factors.get_mut(&i) {
                        None => {
                            factors.insert(i, 1);
                        }
                        Some(item) => {
                            *item = *item + 1;
                        }
                    }
                }
            }
        }
    } else {
        factors.insert(n, 1);
    }
    return factors;
}

fn is_prime(n: i32) -> bool {
    if n < 2 {
        return false;
    } else if n == 2 {
        return true;
    } else if n % 2 == 0 {
        return false;
    } else {
        let root = (n as f32).sqrt() as i32;
        for i in 3..=root {
            if n % i == 0 {
                return false;
            }
        }
    }
    return true;
}