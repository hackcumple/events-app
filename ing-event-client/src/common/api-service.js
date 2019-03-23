import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";

const ApiService = {
    init() {
        Vue.use(VueAxios, axios);
        Vue.axios.defaults.baseURL = "localhost:8080";
    },

    query(resource, params) {
        return Vue.axios.get(resource, params).catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    },

    get(resource, slug = "") {
        return Vue.axios.get(`${resource}/${slug}`).catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    },

    post(resource, params) {
        return Vue.axios.post(`${resource}`, params);
    },

};

export default ApiService;


export const LOLService = {
    query(type, params) {
        return ApiService.query("articles" + (type === "feed" ? "/feed" : ""), {
            params: params
        });
    },
    get(slug) {
        return ApiService.get("talk", slug);
    },
    create(params) {
        return ApiService.post("talk", {
            article: params
        });
    },
    update(slug, params) {
        return ApiService.update("talk", slug, {
            article: params
        });
    },
    destroy(slug) {
        return ApiService.delete(`talk/${slug}`);
    }
};

export const LoginService = {
    login(login, passwd) {
        return ApiService.post("login", {
            login: login,
            password: passwd
        });
    }

    // logout(login, passwd) {
    //     return ApiService.post("login", {
    //         login: login,
    //         password: passwd
    //     });
    // }
};

export const TalkService = {
    sendTalkRate(rate) {
        return ApiService.post("rate", {
            rate: rate
        });
    },

    sendQuestion(question) {
        return ApiService.post("rate",{question:question});
    },

    subscribeForQuestions(talkId) {
        //setInterval bla bla bla
        return ApiService.get("questionsList", talkId);
    }
};

//TO DZIALA ALE CORS!

export const TestApi = {
    testAPI() {
        return axios.get("localhost:8080/api/test").catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    }
};