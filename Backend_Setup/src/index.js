import mongoose from "mongoose";
import { DB_NAME } from "./constants";


// database connection through index.js file
/*
import express from  "express"
const app = express()
;( async () => {


    try {
       await mongoose.connect(`${process.env.MONGO_URI}/${DB_NAME}`)
       app.on("error",(error)=>{
        console.log("Error: ",error);
        throw error
       })

       app.listen(process.env.PORT,()=>{
        console.log(`App is listining on port ${process.env.PORT}`)
       })
    }


    catch (error) {
        console.error("ERROR: ", error)
        throw error;
    }
})()  */
