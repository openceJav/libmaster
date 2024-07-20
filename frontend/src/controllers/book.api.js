import Response from '../utils/response.js'

const readAll = async (body) => {
    try {
        let response = await fetch("http://localhost:3001/book/all", {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': 'true'
            },
            mode: 'cores',
            body: JSON.stringify(body),
            credentials: include
        });

        if (response) {
            return await response.json();
        }

        return new Response("Failure!", "Read all request failed!");
    } catch (err) {
        console.log(err);
    }
}

export default {readAll};