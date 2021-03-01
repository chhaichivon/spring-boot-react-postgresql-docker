import axios from 'axios';
import * as API from './api';
import * as HEADER from './header';

export function getArticlesApi(action) {
    const page = action.page !== undefined ?  action.page : 1;
    const limit = action.limit !== undefined ? action.limit :30;
    const API_URL = API.API_ARTICLES+"?page="+page+"&size="+limit;
    return axios.get(API_URL,HEADER.config)
        .then(function (response) {
            console.log('getArticlesApi response data ', response.data);
            return response.data;
        }).catch(function (error) {
            console.log('getArticlesApi response error ', error);
        })
}

export function getArticleApi(action) {
    const API_URL = API.API_ARTICLES+"/"+action.articleId;
    return axios.get(API_URL,HEADER.config)
        .then(function (response) {
            console.log('getArticleApi response data ', response.data);
            return response.data;
        }).catch(function (error) {
            console.log('getArticleApi response error ', error);
        })
}