import axios from "axios";

export const api = axios.create({
    baseURL: "http://localhost:8080",
});

export const createSession = async (cpf, senha) => {
    api.get("/funcionarios", {id});
    return api.post("/funcionarios", )
};