import React, { useState, useContext } from "react";

import { AuthContext } from "../../contexts/auth";

import './styles.css';
import Footer from "../../footer";
import Navbar from "../../navbar";

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
        <body>
            <Navbar/>
            <div class="flex-box login-container">
                <div class="content-box">
                    <h2>Login</h2>
                    <form onsubmit={handleSubmit}>
                        <div class="input-group">
                            <label htmlFor="CPF"> CPF</label>
                            <input 
                            type="CPF" 
                            id="CPF" 
                            name="CPF"
                            value={CPF}
                            placeholder="Digite seu CPF (apenas números)"
                            onChange={(e) => setCPF(e.target.value)}/>
                        </div>
                        <div class="input-group">
                            <label htmlFor="password"> Senha</label>
                            <input 
                            type="password" 
                            id="password" 
                            name="password" 
                            value={senha}
                            placeholder="Digite sua senha"
                            onchange={(e) => setSenha(e.target.value)}/>
                        </div>
                        <div class="button-group">
                            <button type="submit" class="entrar-button">Entrar</button>
                            <button type="submit" class="recuperar-button">Recuperar senha</button>
                        </div>
                    </form>
                </div>
            </div>
            <Footer/>
        </body>
    )
}

export default LoginPage;