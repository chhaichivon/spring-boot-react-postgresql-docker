import {all,fork, takeLatest,takeEvery} from 'redux-saga/effects'
import * as articleType  from "./../type/ArticleType";
import {getArticlesSaga, getArticleSaga} from "./ArticleSaga";

export default function* rootSaga() {
    yield takeEvery(articleType.GET_ARTICLES, getArticlesSaga);
    yield takeEvery(articleType.GET_ARTICLE, getArticleSaga);
}