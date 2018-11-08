import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import NFRootModel from '../Models/NFRootModel';
import { Button, Dropdown, Icon, message } from 'antd';

export function queryUserList() {

    var url = window.store.host + "/analysis/zone"
    axios.post(url, {
    }, {
        headers: {
            'Content-Type': 'application/json',
            'UserID': window.store.userID,
            'Token': window.store.jwt
        }
    })
    .then(function (response) {
        {response.data.code === 0 && 
            //window.store.setZone(response.data.data);
            console.log("setZone", response.data.data)
        }
  })
  .catch(function (error) {
    message.error(error);
  });

}

export function queryArticleList() {
    var url = window.store.host + "/analysis/itemtypelist"
    axios.post(url, {
    }, {
        headers: {
            'Content-Type': 'application/json',
            'UserID': window.store.userID,
            'Token': window.store.jwt
        }
    })
    .then(function (response) {
        {response.data.code === 0 && 
            //window.store.setItemTypeList(response.data.data);
            console.log("setItemTypeList", response.data.data)
        }
  })
  .catch(function (error) {
    message.error(error);
  });

}
