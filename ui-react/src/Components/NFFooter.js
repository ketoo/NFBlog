import React, { Component } from 'react';
import { Layout} from 'antd';

const { Footer } = Layout;

class NFFooter extends React.Component {
  render() {
    return (
      <Footer style={{ textAlign: 'center' }}>
           NoahFrame Blog System, Author's github: www.github.com/ketoo
      </Footer>
    );
  }
}

export default NFFooter;