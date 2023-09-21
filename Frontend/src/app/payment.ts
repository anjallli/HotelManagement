export class Payment {

    constructor(
        public paymentId:number,
        public customerId:number,
        public totalAmount:number,
        
        public cardNumber:number,
        public cvv:number,
        public cardHolderName:string,
        public status:string
        ){}
}
