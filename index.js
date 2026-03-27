require('dotenv').config()

const express = require('express')
const app = express()
const PORT = 4000

app.get('/', (req, res) => {
  res.send('Hello World!')
})
 
app.get('/twitter',(req,res)=>{
    res.send('aditya raut')
})
 
app.get('/login',(req,res)=>{
  res.send('<h1>Login here </h1>')
})
app.get('/youtube',(req,res)=>{
  res.send("<h2>youtube<h2>")
})

// here process.env.PORT = 4000 simple means that server will run on port number 4000
app.listen(process.env.PORT, () => {  
  console.log(`Example app listening on port ${PORT}`)
})
