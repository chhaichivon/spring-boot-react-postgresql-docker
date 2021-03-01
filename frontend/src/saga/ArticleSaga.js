import {call, put} from 'redux-saga/effects';
import * as articleType  from "./../type/ArticleType";
import {getArticlesApi, getArticleApi} from "../api/ArticleApi";

export function* getArticlesSaga(action) {
    const response = yield call(getArticlesApi, action);
    if(response !== undefined){
        yield put({type: articleType.GET_ARTICLES_SUCCESS, articles:response});
    }else{
        yield put({type: articleType.GET_ARTICLES_FAILURE, articles:response});
    }
}

export function* getArticleSaga(action) {
    const response = yield call(getArticleApi, action);
    if(response !== undefined){
        yield put({type: articleType.GET_ARTICLE_SUCCESS, article: response});
    }else{
        yield put({type: articleType.GET_ARTICLE_FAILURE, article: response});
    }
}
