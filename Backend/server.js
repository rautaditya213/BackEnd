import express from 'express';

const app = express();

// app.get('/',(req,res)=>{
//     res.send('Server is ready');
// });

// get a list of 5 jokes 

app.get('/api/jokes',(req,res)=>{
    const jokes=[
        {
            id: 1,
            title : 'joke2',
            content: 'nahi sangat'
        },
           {
            id: 2,
            title : 'joke2',
            content: 'nahi sangat'
        },   {
            id: 4,
            title : 'joke4',
            content: 'nahi sangat'
        },   {
            id: 5,
            title : 'joke5',
            content: 'nahi sangat'
        },   {
            id: 6,
            title : 'joke6',
            content: 'nahi sangat'
        }
       ]
    res.send(jokes);
});

const port = process.env.PORT || 3000;

app.listen(port,()=>{
    console.log(`serve at http://localhost:${port}`);
});