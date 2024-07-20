import Response from '../utils/response.js'

const readAll = async (body) => {
    try {
        let response = await fetch("http://localhost:3001/user/all", {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': 'true'
            },
            mode: 'cors',
            body: JSON.stringify(body),
            credentials: 'include' 
        });

        if (response) {
            return await response.json();
        }

        return new Response("Failure!", "Read all request failed!");
    } catch (err) {
        console.log(err);
    }
};

const read = async (body) => {
    try {
        let response = await fetch("http://localhost:3001/user", {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': 'true'
            },
            mode: "cors",
            body: JSON.stringify(body),
            credentials: 'include' 
        });

        if (response) {
            return await response.json();
        }

        return new Response("Failure!", "Read all request failed!");
    } catch (err) {
        console.log(err);
    }
};

const create = async (body) => {
    try {
        let response = await fetch("http://localhost:3001/user", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': 'true'
            },
            mode: "cors",
            body: JSON.stringify(body),
            credentials: 'include' 
        });

        if (response) {
            return await response.json();
        }

        return new Response("Failure!", "Account has not been created!");
    } catch (err) {
        console.log(err);
    }
};

const update = async (body) => {
    try {
        let response = await fetch("http://localhost:3001/user", {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': 'true'
            },
            mode: "cors",
            body: JSON.stringify(body),
            credentials: 'include' 
        });

        if (response) {
            return await response.json();
        }

        return new Response("Failure!", "Account has not been updated!");
    } catch (err) {
        console.log(err);
    }
};

const remove = async (body) => {
    try {
        let response = await fetch("http://localhost:3001/user", {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': 'true'
            },
            mode: "cors",
            body: JSON.stringify(body),
            credentials: 'include' 
        });

        if (response) {
            return await response.json();
        }

        return new Response("Failure!", "Account has not been removed!");
    } catch (err) {
        console.log(err);
    }
};

export default {readAll, create, read, update, remove};