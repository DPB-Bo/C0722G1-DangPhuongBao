function Student(id, name, address) {
    this.id;
    this.name;
    this.address;
    this.getInfor = function () {
        return "Id= " + this.id + " Name= " + this.name + " Address= " + this.address;
    }
}
var stundentA = new Student(1, 'Đặng Phương Bảo', 'Nha Trang');
// console.log(Student);
let person = {
    name: {
        first: 'Bob',
        last: 'Smith'
    },
    age: 32,
    gender: 'male',
    interests: ['music', 'skiing'],
    bio: function () {
        alert(this.name[0] + ' ' + this.name[1] + ' is ' + this.age + ' years old. He likes ' + this.interests[0] + ' and ' + this.interests[1] + '.');
    },
    greeting: function () {
        alert('Hi! I\'m ' + this.name[0] + '.');
    }
};

// let a = 'huhu';

// person.name.second = a;
// console.log(person);
// console.log(person.name.second);
// console.log(person.name.first);
// console.log(person['name']['first']);
class Car {
    constructor(ten) {
        this._ten = ten
    }
    setTen(Addname) {
        return this._ten = Addname;
    }
}

car._ten;
car[_ten];
let car = new Car('AB');
alert(car._ten);