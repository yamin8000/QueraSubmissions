pub fn main() {
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap_or_default();
    let inputs: Vec<&str> = input.split(' ').collect();

    let n: i32 = inputs.first()
        .unwrap_or(&"")
        .trim().parse()
        .unwrap_or_default();
    let t = inputs.last().unwrap().trim();

    let key = get_unique_chars(t);

    let mut offs: Vec<String> = vec![];
    for _i in 0..n {
        let mut temp = String::new();
        std::io::stdin().read_line(&mut temp).unwrap_or_default();
        offs.push(temp.trim().parse().unwrap_or_default());
    }
    for off in offs {
        let off_uniques = get_unique_chars(off.as_str());
        if off_uniques.len() != key.len() {
            println!("No")
        } else {
            let mut is_unique = true;
            for off_unique in off_uniques {
                is_unique = is_unique && key.contains(&off_unique);
                if !is_unique {
                    break;
                }
            }
            if is_unique {
                println!("Yes");
            } else {
                println!("No");
            }
        }
    }
}

fn get_unique_chars(input: &str) -> Vec<char> {
    let mut uniques: Vec<char> = vec![];

    for char in input.chars() {
        if !uniques.contains(&char) {
            uniques.push(char);
        }
    }
    uniques
}