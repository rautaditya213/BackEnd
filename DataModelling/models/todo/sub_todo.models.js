import mongoose from "mongoose";

const subTodoSchema = new mongoose.Schema({
    content:{
        type:String,
        required: true
    },
    complete:{
           type: Boolean,
           default: false
    },
    cratedBy:{
        type: mongoose.Schema.Types.ObjectId,
        ref :"User"
    }
},{timestamps: true})

export const subTodo = new mongoose.model("SubTodo", subTodoSchema)