import React, { useState, useContext } from "react";

import { AuthContext } from "../../contexts/auth";

import './styles.css';
import Footer from "../../footer";

const LoginPage = () => {
    const { authenticated, login } = useContext(AuthContext);

    const [CPF, setCPF] = useState("");
    const [senha, setSenha] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log("submit", {CPF, senha});
        
        login(CPF, senha);
    }

    return ( 
        <div id="login">
            <h1 className="title">Login</h1>
            <p>{String(authenticated)}</p>
            <form className="form" onSubmit={handleSubmit}>
                <div className="field">
                    <label htmlFor="CPF">CPF</label>
                    <input 
                    type="CPF" 
                    name="CPF" 
                    id="CPF" 
                    value={CPF} 
                    onChange={(e) => setCPF(e.target.value)}
                    />
                </div>
                <div className="field">
                    <label htmlFor="password">Senha</label>
                    <input 
                    type="password" 
                    name="password" 
                    id="password"
                    value={senha}
                    onChange={(e) => setSenha(e.target.value)}
                    />
                </div>
                <div className="actions">
                    <button type="submit">Entrar</button>
                </div>
            </form>
            <Footer/>
        </div>
    )
}

export default LoginPage;