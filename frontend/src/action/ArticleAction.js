import * as type from './../type/ArticleType';

export function getArticlesAction(page, limit) {
    return {
        type:type.GET_ARTICLES,
        page,
        limit
    }
}

export function getArticleAction(articleId) {
    return {
        type: type.GET_ARTICLE,
        articleId
    }
}