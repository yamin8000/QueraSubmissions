use std::collections::HashMap;

pub fn main() {
    let n: i16 = read_input().trim().parse().unwrap_or_default();

    let mut people: HashMap<String, i16> = HashMap::new();
    let mut orders: Vec<String> = Vec::new();

    for index in 0..n {
        let person = read_input().trim().to_string();
        people.insert(person.clone(), 0);
        orders.insert(index as usize, person)
    }

    for _i in 0..n {
        let current = read_input().trim().to_string();
        let gifts: Vec<i16> = read_input().trim().to_string().split_whitespace()
            .map(|x| x.parse().unwrap_or_default())
            .collect();

        let total_money = match gifts.first() {
            None => { 0 }
            Some(x) => *{ x }
        };

        let receivers = match gifts.last() {
            None => { 0 }
            Some(x) => *{ x }
        };

        if receivers != 0 {
            for _i in 0..receivers.clone() {
                match people.get_mut(&current) {
                    None => {}
                    Some(current_person) => {
                        *current_person -= total_money / receivers;
                    }
                }
                let gifted = read_input().trim().to_string();
                match people.get_mut(&gifted) {
                    None => {}
                    Some(gifted_person) => {
                        *gifted_person += total_money / receivers;
                    }
                }
            }
        }
    }

    for order in orders {
        match people.iter().find(|x| *x.clone().0 == order) {
            None => {}
            Some(person) => {
                println!("{} {}", person.0, person.1)
            }
        }
    }
}

fn read_input() -> String {
    let mut temp = String::new();
    std::io::stdin().read_line(&mut temp).unwrap_or_default();
    temp
}