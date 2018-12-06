import React, { Component } from 'react';
import 'rc-calendar/assets/index.css';
import Calendar from 'rc-calendar';
import RangeCalendar from 'rc-calendar/lib/RangeCalendar';
import enUS from 'rc-calendar/lib/locale/en_US';
import DatePicker from 'rc-calendar/lib/Picker';
import moment from 'moment'

const format = 'YYYY-MM-DD';
const fullFormat = 'YYYY-MM-DD dddd';
const now = moment();

class Picker extends React.Component {
  state = {
    hoverValue: [],
  };

  onHoverChange = (hoverValue) => {
  	
    this.setState({ hoverValue });
  }

  render() {
    const props = this.props;
    const { showValue } = props;
    const calendar = (
      <RangeCalendar
        hoverValue={this.state.hoverValue}
        onHoverChange={this.onHoverChange}
        type={this.props.type}
        locale={enUS}
        defaultValue={now}
        format={format}
        onChange={props.onChange}
        disabledDate={props.disabledDate}
      />);
    return (
      <DatePicker
        open={this.props.open}
        onOpenChange={this.props.onOpenChange}
        calendar={calendar}
        value={props.value}
      >
        {
          () => {
            return (
              <span>
                <input
                  placeholder=" "
                  style={{ width: 250 }}
                  readOnly
                  value={showValue && showValue.format(fullFormat) || ''}
                />
                </span>
            );
          }
        }
      </DatePicker>);
  }
}

export default class CalendarBeomni extends Component {
constructor(props){
    super(props);
	this.state = {
    startValue: null,
    endValue: null,
    startOpen: false,
    endOpen: false,
  };
}

  onStartOpenChange = (startOpen) => {
    this.setState({
      startOpen,
    });
  }

  onEndOpenChange = (endOpen) => {

    this.setState({
      endOpen,
    });
    
  }

  onStartChange = (value) => {
    this.setState({
      startValue: value[0],
      startOpen: false,
      endOpen: true,
    });

  }

  onEndChange = (value) => {
    this.setState({
      endValue: value[1],
    });
   
  }

  disabledStartDate = (endValue) => {
    if (!endValue) {
      return false;
    }
    const startValue = this.state.startValue;
    if (!startValue) {
      return false;
    }
    return endValue.diff(startValue, 'days') < 0;
  }
  componentDidUpdate( prevProps,  prevState)
  {
  	if(prevState.startValue !== this.state.startValue || prevState.endValue !== this.state.endValue ) 
  	 this.props.dateChange(this.state.startValue,this.state.endValue);
  }

  render() {
    const state = this.state;
    return (
      <div style={{ width: 240, margin: 20 }}>
        <p>
          Pick up day:
          <Picker
            onOpenChange={this.onStartOpenChange}
            type="start"
            showValue={state.startValue}
            open={this.state.startOpen}
            value={[state.startValue, state.endValue]}
            onChange={this.onStartChange}
          />
        </p>

        <p>
          Drop off day:
          <Picker
            onOpenChange={this.onEndOpenChange}
            open={this.state.endOpen}
            type="end"
            showValue={state.endValue}
            disabledDate={this.disabledStartDate}
            value={[state.startValue, state.endValue]}
            onChange={this.onEndChange}
          />
        </p>
      </div>);
  }
}
