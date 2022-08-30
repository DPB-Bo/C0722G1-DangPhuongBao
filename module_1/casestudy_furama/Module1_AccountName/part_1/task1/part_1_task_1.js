class Customer {
    constructor(
        name,
        identityCardNumber,
        email,
        address,
        vipRank,
        discount,
        amountPeoples,
        rentDays,
        typeRoom,
        rankRoom
    ) {
        this.name = name;
        this.identityCardNumber = identityCardNumber;
        this.email = email;
        this.address = address;
        this.vipRank = vipRank;
        this.discount = discount;
        this.amountPeoples = amountPeoples;
        this.rentDays = rentDays;
        this.typeRoom = typeRoom;
        this.rankRoom = rankRoom;
    }
}

class TypeRoom {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }
}

let villa = new TypeRoom('Villa', 500);
let house = new TypeRoom('House', 300);
let room = new TypeRoom('Room', 100);