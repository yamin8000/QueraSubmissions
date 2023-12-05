use std::collections::HashSet;
use std::iter::FromIterator;

struct Vec2 {
    x: i64,
    y: i64,
}

pub fn camera_2794() {
    let mut line = String::new();
    let mut numbers: Vec<Vec2> = Vec::new();

    for _i in 0..3 {
        std::io::stdin().read_line(&mut line).unwrap();
        let nums: Vec<&str> = line.split(' ')
            .map(|s| s.trim())
            .collect();
        numbers.push(Vec2 { x: nums.first().unwrap().parse::<i64>().unwrap(), y: nums.last().unwrap().parse::<i64>().unwrap() });
        line = "".parse().unwrap()
    }

    let xs: HashSet<i64> = HashSet::from_iter(numbers.iter().map(|v| v.x));
    let ys: HashSet<i64> = HashSet::from_iter(numbers.iter().map(|v| v.y));
    let mut x: i64 = -1;
    let mut y: i64 = -1;
    for i in xs.clone() {
        for j in ys.clone() {
            let vec = numbers.iter().find(|num| num.x == i && num.y == j);
            match vec {
                None => {
                    x = i;
                    y = j;
                }
                Some(_) => {}
            }
        }
    }
    println!("{} {}", x, y)
}