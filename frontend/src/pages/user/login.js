import React from 'react';
import ctrl from '../../controllers/user.api.js';

class Login extends React.Component {
    render() {
        return (
            <div>
                <h2>
                    Login page
                </h2>
                {/* {
                    ctrl.read({
                        "username": "tristan"
                        ,"password": "tristan"
                    }).then((data) => {
                        console.log(data);
                    })
                } */}
            </div>
        );
    }
}

export default Login;