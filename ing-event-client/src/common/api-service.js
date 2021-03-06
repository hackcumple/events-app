import axios from "axios";
import FormData from 'form-data'

const ApiService = {

    get(slug = "") {
        return axios.get(`http://localhost:8080/api/${slug}`).catch(error => {
            throw new Error(`[RWV] ApiService ${error}`);
        });
    },

    post(slug, params) {
        return axios.post(`http://localhost:8080/api/${slug}`, params);
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

export const TranscriptionService = {
    getTranscription() {
        return ApiService.get(`speech/getTranscriptionDetails/1`);
    }
};


export const AgendaService = {
    getAgenda(ticketId) {
        return ApiService.get(`presentation/tracks/${ticketId}`, {
            value: ticketId
        });
    }
};

export const EventCreationService = {
    createEvent(name, description, image) {
        const data = new FormData();
        data.append('name', name);
        data.append('description', description);
        data.append('file', image, 'event-image.jpeg');
        //add axios request if needed ...
    }
};

export const ImageRecognitionService = {

    uploadPhoto(file) {

        const data = new FormData();
        data.append('file', file, "turbo_image.jpeg");

        return axios.post(`http://localhost:8080/api/face-recognition/image`, file, {
                headers: {
                    'accept': 'image/jpeg',
                    'Accept-Language': 'en-US,en;q=0.8',
                    'Content-Type': `multipart/form-data; boundary=${data._boundary}`,
                }
            });
    }
}