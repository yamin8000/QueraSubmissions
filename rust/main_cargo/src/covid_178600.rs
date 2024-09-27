pub fn main() {
    let n = get_num();
    let k = get_num();
    let p = get_num();
    let q = get_num();

    if n - k > p - q {
        println!("Shekarestan")
    } else if n - k == p - q {
        println!("Equal")
    } else {
        println!("Namakestan")
    }
}

fn get_num() -> i32 {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap_or_default();
    input.trim().parse().unwrap_or_default()
}