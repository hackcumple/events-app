import axios from "axios";
import FormData from 'form-data'

const ApiService = {

    get(slug = "") {
        return axios.get(`http://10.100.99.62:8080/api/${slug}`).catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    },

    post(slug, params) {
        return axios.post(`http://10.100.99.62:8080/api/${slug}`, params);
    },

};

export default ApiService;

// class Test(){

//     getSth = async() =>{
//         await ApiService.get("lolz");
//     }
//}


export const TalkService = {
    sendTalkRate(rate, talkId) {
        return ApiService.post(`presentation/${talkId}/rate`, {
            value: rate,
            date: new Date()
        });
    },

    sendQuestion(question, talkId) {
        return ApiService.post(`/presentation/${talkId}/question`, {
            value: question
        });
    },

    getQuestionsList(talkId) {
        return ApiService.get(`presentation/${talkId}/question`)
    },

    subscribeForQuestions(talkId) {
        //setInterval bla bla bla
        return ApiService.get("questionsList", talkId);
    },

    //convert TAGS to capital letters ?
    getFavouriteTrack(talkId, tags) {
        return ApiService.get(`favouriteTrack/${talkId}/${tags}`);
    }

};

export const TicketService = {
    //this function returns basic info about event ;)
    login(ticketId) {
        return ApiService.get(`login/${ticketId}`, {
            value: ticketId
        });
    }
};

export const ImageRecognitionService = {

    uploadPhoto(file) {

        const data = new FormData();
        data.append('file', file, "turbo_image.jpeg");

        return axios.post(`http://localhost:8080/api/face-recognition/amount`, file, {
                headers: {
                    'accept': 'application/json',
                    'Accept-Language': 'en-US,en;q=0.8',
                    'Content-Type': `multipart/form-data; boundary=${data._boundary}`,
                }
            })
            .then((response) => {
                console.log(response)
            }).catch((error) => {
                //handle error
            });
    }
}