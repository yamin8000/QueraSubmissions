pub fn question_3408() {
    let mut n = String::new();
    let mut input = String::new();

    std::io::stdin().read_line(&mut n).unwrap();
    std::io::stdin().read_line(&mut input).unwrap();
    let words: Vec<&str> = input.split(' ')
        .rev()
        .map(|x| x.trim())
        .collect();

    for word in words {
        print!("{} ", word);
    }
}
