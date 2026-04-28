import mongoose from "mongoose"
import { DB_NAME } from "../constants.js";

const connectDB= async()=>{
    try{
         const connectioncon = await mongoose.connect(`${process.env.MONGODB_URI}/${DB_NAME}`)
         console.log(`\n MongoDb Connected DB host : ${connectioncon.connection.host}`)
    }
    catch(error){
          console.log("mongodb connection Error: " , error)
          process.exit(1)
    }
}

export default connectDB