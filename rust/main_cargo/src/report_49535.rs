pub fn main() {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap();
    let nums: Vec<i32> = input.split(' ')
        .map(|s| s.trim().parse().unwrap())
        .collect();
    let (n, mut k) = (*nums.first().unwrap(), *nums.last().unwrap());

    let mut bottles: Vec<i32> = Vec::new();
    for _i in 0..n {
        bottles.push(get_num())
    }
    for bottle in bottles {
        if k <= 0 {
            break;
        }
        k -= bottle
    }
    if k <= 0 {
        println!("YES")
    } else { println!("NO") }
}

fn get_num() -> i32 {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap();
    input.trim().parse().unwrap()
}