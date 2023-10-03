import React, { useContext } from "react";

import { AuthContext } from "../../contexts/auth";
const HomePage = () => {
    const { authenticated, logout } = useContext(AuthContext);

    const handlelogout = () => {
        logout();
    }

    return (
        <>
        <h1>HomePage</h1>
        <p>{String(authenticated)}</p>
        <button onClick={handlelogout}>Logout</button>
        </>
    );
};

export default HomePage;