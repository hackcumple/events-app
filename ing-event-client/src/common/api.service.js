import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios";
import {
    API_URL
} from "@/common/config";

const ApiService = {
    init() {
        Vue.use(VueAxios, axios);
        Vue.axios.defaults.baseURL = API_URL;
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
    loginUser(login, passwd) {
        return ApiService.post("login", {
            login: login,
            password: passwd
        });
    }
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

export const TestApi = {
    testAPI() {
        return ApiService.get("");
    }
};