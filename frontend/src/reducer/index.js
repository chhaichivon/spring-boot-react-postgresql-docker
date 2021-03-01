import {combineReducers} from "redux";
import {getArticlesReducer,getArticleReducer} from "./ArticleReducer";

const reducers = combineReducers({
    getArticlesReducer:getArticlesReducer,
    getArticleReducer:getArticleReducer
});
export default reducers;