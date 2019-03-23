import axios from "axios";

const ApiService = {

    get(slug = "") {
        return axios.get(`http://10.100.99.62:8081/api/${slug}`).catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    },

    post(slug, params) {
        return axios.post(`http://10.100.99.62:8081/api/${slug}`, params);
    },

};

export default ApiService;

// class Test(){
    
//     getSth = async() =>{
//         await ApiService.get("lolz");
//     }
//}

export const TestApi = {
    testAPI() {
        return axios.get("http://localhost:8080/api/test").catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    },

    testAPI2() {
        return ApiService.get("test");
    }
};

export const TalkService = {
    sendTalkRate(rate, talkId) {
        return ApiService.post(`presentation/${talkId}/rate`, {
            value: rate,
            date: new Date()
        });
    },

    sendQuestion(question, talkId) {
        return ApiService.post(`/presentation/${talkId}/question`, {
            value:question
        });
    },

    getQuestionsList(talkId){
        return ApiService.get(`presentation/${talkId}/question`)
    },

    subscribeForQuestions(talkId) {
        //setInterval bla bla bla
        return ApiService.get("questionsList", talkId);
    }

};

export const TicketService = {
    //this function returns basic info about event ;)
    login(ticketId) {
        return ApiService.post(`login/${ticketId}`, {
            value:ticketId
        });
    }

    // logout(login, passwd) {
    //     return ApiService.post("login", {
    //         login: login,
    //         password: passwd
    //     });
    // }
};
