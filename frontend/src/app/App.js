import React, {Component} from 'react';
import { Table, Layout, Button, Modal } from 'antd';
import {bindActionCreators} from "redux";
import {getArticlesAction, getArticleAction} from "../action/ArticleAction";
import {connect} from "react-redux";

import './App.css';
const { Header, Footer, Sider, Content } = Layout;


const columns = [
    {
        title: 'ID',
        width: 100,
        dataIndex: 'id',
        key: 'id',
        fixed: 'left',
    },
    {
        title: 'Title',
        width: 100,
        dataIndex: 'title',
        key: 'title',
        fixed: 'left',
    },
    {
        title: 'Body',
        dataIndex: 'body',
        key: 'body',
        width: 300,
    },
    {
        title: 'Status',
        dataIndex: 'status',
        key: 'status',
        width: 50,
    },
    {
        title: 'Created By',
        dataIndex: 'createdBy',
        key: 'createdBy',
        width: 100,
    },
    {
        title: 'Created At',
        dataIndex: 'createdAt',
        key: 'createdAt',
        width: 100,
    },
    {
        title: 'Updated By',
        dataIndex: 'updatedBy',
        key: 'updatedBy',
        width: 100,
    },
    {
        title: 'Updated At',
        dataIndex: 'updatedAt',
        key: 'updatedAt',
        width: 100,
    },
    {
        title: 'Action',
        key: 'operation',
        fixed: 'right',
        width: 100,
        render: () => <a>action</a>,
    },
];

class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            articles : [],
            isLoading: true,
            visible:false
        };
        this.props.getArticlesAction(1,30);
    }

    componentWillReceiveProps(nextProps) {
        const articlesData = [];
        if(nextProps.articles.data !== undefined && nextProps.articles.data &&  nextProps.articles.data.length > 0){
            const dataAPI = nextProps.articles.data;
            for (let i = 0; i < dataAPI.length; i++) {
                articlesData.push({
                    key: dataAPI[i].id,
                    id:dataAPI[i].id,
                    title: dataAPI[i].title,
                    body: dataAPI[i].body,
                    status:'ACTIVE',
                    createdBy:'Chhai Chivon',
                    createdAt:'2021-FEB-25',
                    updatedBy:'Chhai Chivon',
                    updatedAt:'2021-FEB-25'
                });
            }
            this.setState({
                articles: articlesData,
                isLoading: false,
                visible:false
            });
        }
    }

    state = {
        loading: false,
        visible: false,
    };

    showModal = () => {
        this.setState({
            visible: true,
        });
    };

    handleOk = () => {
        this.setState({ loading: true });
        setTimeout(() => {
            this.setState({ loading: false, visible: false });
        }, 3000);
    };

    handleCancel = () => {
        this.setState({ visible: false });
    };

    render() {
        const { visible, loading } = this.state;
        return (
            <Layout>
                <Header className={'appHeader'}>

                </Header>
                <Layout>
                    <Sider className={'appSider'}>
                        <Button type="primary" onClick={this.showModal}>
                            Add new article
                        </Button>
                    </Sider>
                    <Content>
                        {
                            this.state.isLoading ? <h3>Loading...</h3> : (
                                <Table key={"article"} columns={columns} dataSource={this.state.articles} scroll={{ x: 1500 }} sticky />
                            )
                        }
                        <Modal
                            visible={visible}
                            title="Add new article"
                            onOk={this.handleOk}
                            onCancel={this.handleCancel}
                            footer={[
                                <Button key="back" onClick={this.handleCancel}>
                                    Cancel
                                </Button>,
                                <Button key="submit" type="primary" loading={loading} onClick={this.handleOk}>
                                    Submit
                                </Button>,
                            ]}
                        >
                            <p>Some contents...</p>
                            <p>Some contents...</p>
                            <p>Some contents...</p>
                            <p>Some contents...</p>
                            <p>Some contents...</p>
                        </Modal>
                    </Content>
                </Layout>
                <Footer className={'appFooter'}>Footer</Footer>
            </Layout>
        );
    }
}

const mapStateToProps = state => {
    return {
        articles: state.getArticlesReducer.articles
    }
};

const mapDispatchToProps = dispatch => {
    return bindActionCreators({getArticlesAction}, dispatch);
};

export default connect(mapStateToProps, mapDispatchToProps)(App);



