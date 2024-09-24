pub fn main() {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap_or_default();
    let inputs: Vec<i32> = input.split(" ")
        .map(|x| x.trim().parse().unwrap_or_default())
        .collect();
    let n = inputs[0];

    let mut sum = 0;

    for i in 1..=n {
        for j in 1..5 {
            if i % inputs[j] == 0 {
                sum = sum + 1;
                break
            }
        }
    }
    println!("{}", sum)
}